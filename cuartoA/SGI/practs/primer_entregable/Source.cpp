constexpr auto PROYECTO = "PROYECTO";

#include <iostream>	
#include <codebase.h>
#include <vector>

using namespace cb;
static GLuint wheel;
static GLuint axis;
static float rotationAngle = 0.0f;
static float rotationAngleCabin = 0.0f;

const float rotationSpeed = 360.0f / 6.0f; int fps = 60;       

vector<Vec3> puntosCircunferencia(float radio, int numPuntos, float desfase, float Z)
{
	vector<Vec3> puntos;
	for (float angulo = desfase; angulo < 2 * PI + desfase; angulo += 2 * PI / numPuntos)
		puntos.push_back(Vec3(radio * cos(angulo), radio * sin(angulo), Z));
	return puntos;
}

void draw_axis(float desfase, int numPuntos, float starting_radio) 
{
	// AXIS
	float axis_r = starting_radio;

	axis = glGenLists(1);
	glNewList(axis, GL_COMPILE);

	glColor3f(1.0f, 1.0f, 1.0f);

	vector<Vec3> axis;

	axis = puntosCircunferencia(axis_r, numPuntos, 0, 0);

	glBegin(GL_TRIANGLE_STRIP);
	for (int i = 0; i <= numPuntos; i++) {
		int idx = i % numPuntos;		
		glVertex3f(axis[idx].x, axis[idx].y, axis[idx].z - desfase*2.8);
		glVertex3f(axis[idx].x, axis[idx].y, axis[idx].z + desfase*1.5);
	}
	glEnd();

	// OUTER SCREWS
	glColor3f(0.0f, 1.0f, 1.0f);

	axis = puntosCircunferencia(axis_r+0.02, numPuntos, 0, 0);

	glBegin(GL_TRIANGLE_STRIP);
	for (int i = 0; i <= numPuntos; i++) {
		int idx = i % numPuntos;
		glVertex3f(axis[idx].x, axis[idx].y, axis[idx].z + desfase*0.75);
		glVertex3f(axis[idx].x, axis[idx].y, axis[idx].z + desfase * 1.25);
	}
	glEnd();

	glBegin(GL_TRIANGLE_STRIP);
	for (int i = 0; i <= numPuntos; i++) {
		int idx = i % numPuntos;
		glVertex3f(axis[idx].x, axis[idx].y, axis[idx].z - desfase * 2);
		glVertex3f(axis[idx].x, axis[idx].y, axis[idx].z - desfase * 2.5);
	}
	glEnd();

	// Draw the bottom cap (filling the bottom face)
	glBegin(GL_TRIANGLE_FAN);
	glVertex3f(0.0f, 0.0f, axis[0].z + desfase * 0.75); // Center of the bottom circle
	for (int i = 0; i <= numPuntos; i++) {
		int idx = i % numPuntos; // Wrap around to close the fan
		glVertex3f(axis[idx].x, axis[idx].y, axis[idx].z + desfase * 0.75);
	}
	glEnd();

	// Draw the top cap (filling the top face)
	glBegin(GL_TRIANGLE_FAN);
	glVertex3f(0.0f, 0.0f, axis[0].z + desfase * 1.25); // Center of the top circle
	for (int i = 0; i <= numPuntos; i++) {
		int idx = i % numPuntos; // Wrap around to close the fan
		glVertex3f(axis[idx].x, axis[idx].y, axis[idx].z + desfase * 1.25);
	}
	glEnd();

	// Draw the bottom cap (filling the bottom face)
	glBegin(GL_TRIANGLE_FAN);
	glVertex3f(0.0f, 0.0f, axis[0].z - desfase * 2); // Center of the bottom circle
	for (int i = 0; i <= numPuntos; i++) {
		int idx = i % numPuntos; // Wrap around to close the fan
		glVertex3f(axis[idx].x, axis[idx].y, axis[idx].z - desfase * 2);
	}
	glEnd();

	// Draw the top cap (filling the top face)
	glBegin(GL_TRIANGLE_FAN);
	glVertex3f(0.0f, 0.0f, axis[0].z - desfase * 2.5); // Center of the top circle
	for (int i = 0; i <= numPuntos; i++) {
		int idx = i % numPuntos; // Wrap around to close the fan
		glVertex3f(axis[idx].x, axis[idx].y, axis[idx].z - desfase * 2.5);
	}
	glEnd();

	// SUPPORT
	glLineWidth(10.0f);
	glBegin(GL_LINES);
		glVertex3f(0.0f, 0.0f, desfase * 1);  // Starting point of the line
		glVertex3f(-starting_radio * 10, -starting_radio*18, desfase); // Ending point of the line
	glEnd();

	glBegin(GL_LINES);
		glVertex3f(0.0f, 0.0f, desfase * 1);  // Starting point of the line
		glVertex3f(+starting_radio * 10, -starting_radio*18, desfase); // Ending point of the line
	glEnd();

	glLineWidth(10.0f); 
	glBegin(GL_LINES);
		glVertex3f(0.0f, 0.0f, -desfase * 2.2);  // Starting point of the line
		glVertex3f(-starting_radio * 10, -starting_radio * 18, -desfase * 2.2); // Ending point of the line
	glEnd();

	glBegin(GL_LINES);
		glVertex3f(0.0f, 0.0f, -desfase * 2.2);  // Starting point of the line
		glVertex3f(+starting_radio * 10, -starting_radio * 18, -desfase * 2.2); // Ending point of the line
	glEnd();

	glEndList();
}

void draw_cube(float size) {
	glBegin(GL_QUADS);

	// Front face
	glVertex3f(-size / 2, -size / 2, size / 2);
	glVertex3f(size / 2, -size / 2, size / 2);
	glVertex3f(size / 2, size / 2, size / 2);
	glVertex3f(-size / 2, size / 2, size / 2);

	// Back face
	glVertex3f(-size / 2, -size / 2, -size / 2);
	glVertex3f(-size / 2, size / 2, -size / 2);
	glVertex3f(size / 2, size / 2, -size / 2);
	glVertex3f(size / 2, -size / 2, -size / 2);

	// Left face
	glVertex3f(-size / 2, -size / 2, -size / 2);
	glVertex3f(-size / 2, -size / 2, size / 2);
	glVertex3f(-size / 2, size / 2, size / 2);
	glVertex3f(-size / 2, size / 2, -size / 2);

	// Right face
	glVertex3f(size / 2, -size / 2, -size / 2);
	glVertex3f(size / 2, size / 2, -size / 2);
	glVertex3f(size / 2, size / 2, size / 2);
	glVertex3f(size / 2, -size / 2, size / 2);


	// Bottom face
	glVertex3f(-size / 2, -size / 2, size / 2);
	glVertex3f(-size / 2, -size / 2, -size / 2);
	glVertex3f(size / 2, -size / 2, -size / 2);
	glVertex3f(size / 2, -size / 2, size / 2);

	glEnd();

	// WIREFRAMES

	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
	glLineWidth(2.0f);
	glColor3f(1.0f, 1.0f, 0.0f);

	glBegin(GL_QUADS);
	// Front face
	glVertex3f(-size / 2, -size / 2, size / 2);
	glVertex3f(size / 2, -size / 2, size / 2);
	glVertex3f(size / 2, size / 2, size / 2);
	glVertex3f(-size / 2, size / 2, size / 2);

	// Back face
	glVertex3f(-size / 2, -size / 2, -size / 2);
	glVertex3f(-size / 2, size / 2, -size / 2);
	glVertex3f(size / 2, size / 2, -size / 2);
	glVertex3f(size / 2, -size / 2, -size / 2);

	// Left face
	glVertex3f(-size / 2, -size / 2, -size / 2);
	glVertex3f(-size / 2, -size / 2, size / 2);
	glVertex3f(-size / 2, size / 2, size / 2);
	glVertex3f(-size / 2, size / 2, -size / 2);

	// Right face
	glVertex3f(size / 2, -size / 2, -size / 2);
	glVertex3f(size / 2, size / 2, -size / 2);
	glVertex3f(size / 2, size / 2, size / 2);
	glVertex3f(size / 2, -size / 2, size / 2);

	// Bottom face
	glVertex3f(-size / 2, -size / 2, size / 2);
	glVertex3f(-size / 2, -size / 2, -size / 2);
	glVertex3f(size / 2, -size / 2, -size / 2);
	glVertex3f(size / 2, -size / 2, size / 2);

	glEnd();

	glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
}

void draw_carousel(float x, float y, float z, float desfase, float angle) {
	float size = 0.10f;
	
	glRotatef(angle, 0, 0, 1);

	glPushMatrix();
	glTranslatef(x, y - size / 2, z);
	glColor3f(0.8f, 0.5f, 0.0f);
	draw_cube(size);

	// DECORATION
	glColor3f(1.0f, 1.0f, 1.0f);
	int numPuntos = 14;
	vector<Vec3> circle;

	circle = puntosCircunferencia(0.07, numPuntos, 0, 0);

	glBegin(GL_LINE_LOOP);
	for (int i = 0; i < numPuntos; i++) {
		glVertex3f(circle[i].x, circle[i].y, circle[i].z - size/2 );
	}
	glEnd();

	glBegin(GL_LINE_LOOP);
	for (int i = 0; i < numPuntos; i++) {
		glVertex3f(circle[i].x, circle[i].y, circle[i].z + size/2 );
	}
	glEnd();
	glPopMatrix();

	glPushMatrix();

	glTranslatef(x, y, z);
	glColor3f(1.0f, 1.0f, 0.0f);

	circle = puntosCircunferencia(0.05, numPuntos, 0, 0);

	glBegin(GL_LINE_LOOP);
	for (int i = 0; i < numPuntos; i++) {
		glVertex3f(circle[i].x, circle[i].y, circle[i].z - size / 2 - 0.001);
	}
	glEnd();

	glBegin(GL_LINE_LOOP);
	for (int i = 0; i < numPuntos; i++) {
		glVertex3f(circle[i].x, circle[i].y, circle[i].z + size / 2 + 0.001);
	}
	glEnd();
	
	// ROOF-CONNECTION AND ROOF
	for (int i = 0; i < numPuntos; i++) {
		// Draw lines connecting corresponding vertices on the front and back
		glBegin(GL_LINES); // Use GL_LINES for a single line between two vertices
		glVertex3f(circle[i].x, circle[i].y, circle[i].z + size / 2); // Back vertex
		glVertex3f(circle[i].x, circle[i].y + 0.05, circle[i].z + size / 2); // Front vertex
		glEnd();

		glBegin(GL_LINES);
		glVertex3f(circle[i].x, circle[i].y, circle[i].z - size / 2); // Back vertex
		glVertex3f(circle[i].x, circle[i].y + 0.05, circle[i].z - size / 2); // Front vertex
		glEnd();

		glBegin(GL_TRIANGLE_STRIP); // Begin drawing the triangle strip
		for (int i = 0; i < numPuntos; i++) {
			if (circle[i].y + 0.05 > (circle[0].y + circle[numPuntos/2].y)*0.5 + 0.03) { // Check if the y height meets the threshold
				// Add vertices for the front and back of the cube
				glVertex3f(circle[i].x, circle[i].y + 0.05, circle[i].z - size / 2); // Back vertex
				glVertex3f(circle[i].x, circle[i].y + 0.05, circle[i].z + size / 2); // Front vertex
			}
		}
		glEnd();
	}
	glPopMatrix();
}

void draw_wheel(float starting_radio, int numPuntos, float desfase)
{
	float axis_r = starting_radio;
	float axis_m = starting_radio * 6;
	float axis_mt = starting_radio * 11;
	float axis_o = starting_radio * 15;
	float deco_r = starting_radio;
	float deco_o = starting_radio * 16;

	vector<Vec3> axis = puntosCircunferencia(axis_r, numPuntos, 0, 0);
	vector<Vec3> middle = puntosCircunferencia(axis_m, numPuntos, 0, 0);
	vector<Vec3> middle_t = puntosCircunferencia(axis_mt, numPuntos, 0, 0);
	vector<Vec3> outer = puntosCircunferencia(axis_o, numPuntos, 0, 0.0);
	vector<Vec3> decoration_axis = puntosCircunferencia(deco_r, numPuntos * 2, 0, 0);
	vector<Vec3> decoration_outer = puntosCircunferencia(deco_o, numPuntos * 2, 0, 0);

	vector<vector<Vec3>> array = { axis, middle, middle_t, outer };

	wheel = glGenLists(1);
	glNewList(wheel, GL_COMPILE);
	for (const auto& element : array) {

		// WHEELS
		glColor3f(1.0f, 1.0f, 1.0f);

		if (element == array[array.size()-1]) 
			glLineWidth(4.0f);
		else 
			glLineWidth(1.0f);

		glBegin(GL_LINE_LOOP);
		for (int i = 0; i < numPuntos; i++) {
			glVertex3f(element[i].x, element[i].y, element[i].z);
		}
		glEnd();

		glColor3f(1.0f, 1.0f, 1.0f);
		glBegin(GL_LINE_LOOP);
		for (int i = 0; i < numPuntos; i++) {
			glVertex3f(element[i].x, element[i].y, element[i].z - desfase);
		}
		glEnd();
		
		if (element == array[array.size() - 1]) continue;

		// FRAME
		glBegin(GL_LINES);
		for (int i = 0; i < numPuntos; i++) {
			glVertex3f(element[i].x, element[i].y, element[i].z);
			glVertex3f(element[i].x, element[i].y, element[i].z - desfase);
		}
		glEnd();
	}
	
		// FRAME
		glColor3f(.5f, .6f, 0.2f);

		glBegin(GL_LINES);  		
		glLineWidth(2.0f);
		for (int i = 0; i < numPuntos; i++) {
			glVertex3f(axis[i].x, axis[i].y, axis[i].z + 0.05);
			glVertex3f(outer[i].x, outer[i].y, outer[i].z );
		}
		glEnd();

		glBegin(GL_LINES);  		
		glLineWidth(2.0f);
		for (int i = 0; i < numPuntos; i++) {
			glVertex3f(axis[i].x, axis[i].y, axis[i].z - desfase - 0.08);
			glVertex3f(outer[i].x, outer[i].y, outer[i].z - desfase);
		}
		glEnd();	

		glColor3f(1.0f, 1.0f, 1.0f);

		glLineWidth(1.0f);

		// CROSS-FRAME
		glBegin(GL_LINES);
		for (int i = 0; i < numPuntos; i++) {
			for (int j = 0; j < array.size() - 1; j++) {
				glVertex3f(array[j][i].x, array[j][i].y, array[j][i].z - desfase);
				glVertex3f(array[j][i+1].x, array[j][i+1].y, array[j][i+1].z);
			}
		}
		glEnd();

		glBegin(GL_LINES);
		for (int i = 0; i < numPuntos; i++) {
			for (int j = 0; j < array.size() - 1; j++) {
				glVertex3f(array[j][i+1].x, array[j][i+1].y, array[j][i+1].z - desfase);
				glVertex3f(array[j][i].x, array[j][i].y, array[j][i].z);
			}
		}
		glEnd();

		glBegin(GL_LINES);
		for (int i = 0; i < numPuntos; i++) {
			for (int j = 0; j < array.size() - 2; j++) {
				glVertex3f(array[j+1][i].x, array[j+1][i].y, array[j+1][i].z - desfase);
				glVertex3f(array[j][i].x, array[j][i].y, array[j][i].z);
			}
		}
		glEnd();

		glBegin(GL_LINES);
		for (int i = 0; i < numPuntos; i++) {
			for (int j = 0; j < array.size() - 2; j++) {
				glVertex3f(array[j][i].x, array[j][i].y, array[j][i].z - desfase);
				glVertex3f(array[j+1][i].x, array[j+1][i].y, array[j+1][i].z);
			}
		}
		glEnd();

		glLineWidth(3.0f);

		// DECORATION
		glBegin(GL_LINES);
		for (int i = 0; i < 26; i++) {
			glVertex3f(decoration_axis[i].x, decoration_axis[i].y, decoration_axis[i].z);
			glVertex3f(decoration_outer[i].x, decoration_outer[i].y, decoration_outer[i].z);
		}
		glEnd();

		glBegin(GL_LINES);
		for (int i = 0; i < numPuntos * 2; i++) {
			glVertex3f(decoration_axis[i].x, decoration_axis[i].y, decoration_axis[i].z - desfase);
			glVertex3f(decoration_outer[i].x, decoration_outer[i].y, decoration_outer[i].z - desfase);
		}
		glEnd();

		// CAROUSEL
		//for (int i = 0; i < numPuntos; i++) 
		//{
		//	draw_carousel(array[array.size() - 1][i].x, array[array.size() - 1][i].y, (array[array.size() - 1][i].z - desfase + array[array.size() - 1][i].z) * 0.5, 0.5);
		//}

	glEndList();
}

void reshape(GLint w, GLint h)
{
	glViewport(0, 0, w, h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluPerspective(45.0, (double)w / (double)h, 1.0, 100.0);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
}

void display()
{
	float axis_o = 0.05 * 15;

	vector<Vec3> outer = puntosCircunferencia(axis_o, 18, 0, 0.0);

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glLoadIdentity();
	glTranslatef(0.0f, -0.05f, -3.0f);
	glCallList(axis);

	glRotatef(rotationAngle, 0.0f, 0.0f, 1.0f);
	glPushMatrix();

	for (int i = 0; i < 18; i++) {
		float angle = 2.0f * PI * i / 18 + rotationAngle * PI / 180.0f; // Angle for each cart
		float x = axis_o * cos(angle);
		float y = axis_o * sin(angle);
		float z = 0.0f; // Assuming the carts are in the z=0 plane

		std::cout << "angle" << angle;

		// Calculate the angle to keep the cart facing downward
		float cartAngle = atan2(y, x) * 180.0f / PI + 90.0f;

		// Draw each cart dynamically
		draw_carousel(x, y, z, 0.1, angle);
	}

	glPopMatrix();

	glCallList(wheel);
	glutSwapBuffers();
}

void update(int value)
{
	// Calculate the rotation increment based on FPS
	rotationAngle += rotationSpeed / fps;
	if (rotationAngle >= 360.0f) {
		rotationAngle -= 360.0f; // Keep angle within [0, 360)
	}

	// Redisplay and reset the timer
	glutPostRedisplay();
	glutTimerFunc(1000 / fps, update, 0);
}


void init()
{
	glEnable(GL_DEPTH_TEST);
	glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	draw_wheel(0.05, 18, 0.1);
	draw_axis(0.1, 18, 0.05);
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(600, 600);
	glutInitWindowPosition(50, 50);
	glutCreateWindow(PROYECTO);
	init();
	glutDisplayFunc(display);
	glutReshapeFunc(reshape);
	glutTimerFunc(0, update, 0); // Start the animation timer
	glutMainLoop();
}

