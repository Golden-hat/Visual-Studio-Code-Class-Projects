#include <GL/glut.h>
#include <cmath>
#include <iostream>
#include <codebase.h>

using namespace cb;

#include <GL/glut.h>
#include <cmath>
#include <iostream>

constexpr float INITIAL_SPEED = 0.0001f;
constexpr float MAX_SPEED = 0.001f;
constexpr float MIN_SPEED = 0.0001f;
constexpr float SPEED_INCREMENT = 0.00005f;
constexpr float MOUSE_SENSITIVITY = 0.20f; 
constexpr int GRID_SIZE = 1000;  
constexpr float CAMERA_Z = 3.0f;  

GLuint grid;
float speed = INITIAL_SPEED;
float yaw = 0.0f;   
float pitch = 0.0f;   
float posX = 0.0f, posY = 0.0f, posZ = CAMERA_Z;
int lastMouseX = 0, lastMouseY = 0; 

void generate_grid()
{
    grid = glGenLists(1);
    glNewList(grid, GL_COMPILE);

    glColor3f(1.0f, 1.0f, 1.0f);
    glBegin(GL_LINES);

    for (int i = -GRID_SIZE; i <= GRID_SIZE; ++i)
    {
        glVertex3f(i, -GRID_SIZE, 0.0f);
        glVertex3f(i, GRID_SIZE, 0.0f);
    }

    for (int i = -GRID_SIZE; i <= GRID_SIZE; ++i)
    {
        glVertex3f(-GRID_SIZE, i, 0.0f);
        glVertex3f(GRID_SIZE, i, 0.0f);
    }

    glEnd();
    glEndList();
}

void animate(int n) 
{
    float frontX = cos(yaw * PI / 180.0f);
    float frontZ = sin(pitch * PI / 180.0f);
    float frontY = -sin(yaw * PI / 180.0f);

    gluLookAt(posX, posY, posZ, posX + frontX, posY + frontY, posZ + frontZ, 0.0, 0.0, 1.0);

	posX += speed * frontX;
	posY += speed * frontY;
	posZ += speed * frontZ;

    glutPostRedisplay();
    glutTimerFunc(16, animate, 0); 
}


void reshape(GLint w, GLint h)
{
    glViewport(0, 0, w, h);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(45.0, (double)w / (double)h, 0.1, 100.0);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}

void display()
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glLoadIdentity();

    animate(0);

    glCallList(grid);

    glutSwapBuffers();
}

void passive_motion(int x, int y)
{
    int deltaX = x - lastMouseX;
    int deltaY = y - lastMouseY;

    // Adjust yaw and pitch based on mouse movement
    yaw += deltaX * MOUSE_SENSITIVITY;
    pitch -= deltaY * MOUSE_SENSITIVITY;  // Invert vertical movement

    // Clamp the pitch to prevent extreme rotations (gimbal lock)
    if (pitch > 89.0f) pitch = 89.0f;
    if (pitch < -89.0f) pitch = -89.0f;

    // Store the current mouse position for the next frame
    lastMouseX = x;
    lastMouseY = y;
}

void keyboard(unsigned char key, int x, int y)
{
    switch (key)
    {
    case 'a': // Accelerate
        speed += SPEED_INCREMENT;
        if (speed > MAX_SPEED)
            speed = MAX_SPEED;
        break;
    case 'z': // Decelerate
        speed -= SPEED_INCREMENT;
        if (speed < MIN_SPEED)
            speed = MIN_SPEED;
        break;
    }
}

int main(int argc, char** argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize(1920, 1080);
    glutInitWindowPosition(50, 50);
    glutCreateWindow("3D Flight Camera");

    generate_grid();

    glutDisplayFunc(display);
    glutReshapeFunc(reshape);
    glutPassiveMotionFunc(passive_motion);
    glutKeyboardFunc(keyboard);


    lastMouseX = glutGet(GLUT_WINDOW_WIDTH) / 2;
    lastMouseY = glutGet(GLUT_WINDOW_HEIGHT) / 2;

    glutMainLoop();

    return 0;
}

