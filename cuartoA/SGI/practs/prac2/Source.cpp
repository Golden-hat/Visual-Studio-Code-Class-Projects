#define PROYECTO "Geometria"

#include <iostream>	
#include <codebase.h>
#include <vector>

using namespace cb;
static GLuint engranaje;

//Funcion de muestreo de una circunferencia
vector<Vec3> puntosCircunferencia(float radio, int numPuntos, float desfase, float Z)
{
	vector<Vec3> puntos;
	for (float angulo = desfase; angulo < 2 * PI + desfase; angulo += 2 * PI / numPuntos)
		puntos.push_back(Vec3(radio * cos(angulo), radio * sin(angulo), Z));
	return puntos;
}

void gear2D(int nPuntos, float desfase, float pico, float valle, float eje, float Z)
{
	vector<Vec3> pExterior = puntosCircunferencia(valle, nPuntos, desfase - PI / nPuntos, Z);
	vector<Vec3> pInterior = puntosCircunferencia(eje, nPuntos, desfase, Z);
	vector<Vec3> pFar = puntosCircunferencia(pico, nPuntos, desfase, Z);

	engranaje = glGenLists(1);
	glNewList(engranaje, GL_COMPILE);
	glBegin(GL_QUAD_STRIP);
	for (int i = 0; i < nPuntos; i++) {
		glBegin(GL_TRIANGLE_STRIP);
		glVertex3fv(pInterior[i % nPuntos]);
		glVertex3fv(pExterior[i % nPuntos]);
		glVertex3fv(pExterior[(i + 1) % nPuntos]);
		glVertex3fv(pFar[i % nPuntos]);
		glEnd();
	}
	glEndList();
}

void gear3D(int nPuntos, float desfase, float pico, float valle, float eje) 
{
	
}

GLuint copyAndTranslate(GLuint originalList, GLfloat translateX, GLfloat translateY, GLfloat translateZ)
{
	GLuint newList = glGenLists(1);

	// Start compiling the new display list
	glNewList(newList, GL_COMPILE);

	// Apply the translation
	glTranslatef(translateX, translateY, translateZ);

	// Call the original display list
	glCallList(originalList);

	// End the new display list
	glEndList();

	return newList;
}

void init()
{
	gear2D(10, PI / 2, 0.9, 0.4, 0.2, 0);
}

// Funcion de atencion al evento de dibujo
void display()
{
	glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	glClear(GL_COLOR_BUFFER_BIT)

	glRotatef(10, 0, 1, 0);

	glPushMatrix();

		/* Dibujo cuerpo engranaje */
		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		glColor3fv(VERDE);
		glCallList(engranaje);

		GLuint copy = copyAndTranslate(engranaje, 0.0f, 0.0f, 0.1f);
		glPushMatrix();

			/* Dibujo outline engranaje*/
			glPolygonMode(GL_FRONT, GL_LINE);
			glColor3fv(BLANCO);
			glLineWidth(1);
			glRotatef(180, 0, 1, 0);
			glCallList(copy);

		glPopMatrix();

	glPopMatrix();

	glFlush();
}

// Funcion de atencion al redimensionamiento
void reshape(GLint w, GLint h)
{
}

int main(int argc, char** argv)
{
	// Inicializaciones
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(500, 500);
	glutInitWindowPosition(50, 50);

	// Crear ventana
	glutCreateWindow(PROYECTO);

	// Funcion de inicializacion propia
	init();

	// Registrar callbacks
	glutDisplayFunc(display);
	glutReshapeFunc(reshape);

	// Bucle de atencion a eventos
	glutMainLoop();
}
