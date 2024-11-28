#include <GL/glut.h>
#include <cmath>
#include <iostream>
#include <codebase.h>

using namespace cb;

constexpr float INITIAL_SPEED = 0.05f;
constexpr float MAX_SPEED = 0.5f;
constexpr float MIN_SPEED = 0.05f;
constexpr float SPEED_INCREMENT = 0.025f;
constexpr float MOUSE_SENSITIVITY = 0.05f;
constexpr int GRID_SIZE = 10000;
constexpr float CAMERA_Z = 3.0f;

GLuint grid;
float speed = INITIAL_SPEED;
float yaw = 0.0f;
float pitch = 0.0f;
float posX = 0.0f, posY = 0.0f, posZ = CAMERA_Z;
int lastMouseX = 0, lastMouseY = 0;

float fps = 165;

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

void update_camera()
{
    float frontX = cos(yaw * PI / 180.0f);
    float frontZ = sin(pitch * PI / 180.0f);
    float frontY = -sin(yaw * PI / 180.0f);

    gluLookAt(posX, posY, posZ, posX + frontX, posY + frontY, posZ + frontZ, 0.0, 0.0, 1.0);

    glutPostRedisplay();
}

void animate(int n)
{
    float frontX = cos(yaw * PI / 180.0f);
    float frontZ = sin(pitch * PI / 180.0f);
    float frontY = -sin(yaw * PI / 180.0f);

    posX += speed * frontX;
    posY += speed * frontY;
    posZ += speed * frontZ;

    glutTimerFunc(1000/fps, animate, 0); 
}

void reshape(GLint w, GLint h)
{
    glViewport(0, 0, w, h);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(60.0, (double)w / (double)h, 0.1, 1000.0);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}

void display()
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glLoadIdentity();
    update_camera();
    glCallList(grid);
    glutSwapBuffers();
}

void passive_motion(int x, int y)
{
    int centerX = glutGet(GLUT_WINDOW_WIDTH) / 2;
    int centerY = glutGet(GLUT_WINDOW_HEIGHT) / 2;

    int deltaX = x - lastMouseX;
    int deltaY = y - lastMouseY;

    if (x < lastMouseX)
        yaw -= MOUSE_SENSITIVITY * abs(deltaX);
    else if (x > lastMouseX)
        yaw += MOUSE_SENSITIVITY * abs(deltaX);

    if (y < lastMouseY)
        pitch += MOUSE_SENSITIVITY * abs(deltaY);
    else if (y > lastMouseY)
        pitch -= MOUSE_SENSITIVITY * abs(deltaY);

    if (pitch > 100.0f) pitch = 100.0f;
    if (pitch < -100.0f) pitch = -100.0f;

    glutWarpPointer(centerX, centerY);

    lastMouseX = centerX;
    lastMouseY = centerY;
}

void keyboard(unsigned char key, int x, int y)
{
    switch (key)
    {
    case 'a': 
        speed += SPEED_INCREMENT;
        if (speed > MAX_SPEED)
            speed = MAX_SPEED;
        break;
    case 'z': 
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

    glutSetCursor(GLUT_CURSOR_NONE);

    lastMouseX = glutGet(GLUT_WINDOW_WIDTH) / 2;
    lastMouseY = glutGet(GLUT_WINDOW_HEIGHT) / 2;

    glutTimerFunc(1000/fps, animate, 0); 
    glutMainLoop();

    return 0;
}

