// Ejemplo con opeadores logicos: 6 errores
//-----------------------------------------
int main() 
{
  int a[20];
  bool b;
  int  c=0;
  bool a;                         // Variable repetida

  for (a; b; c=c+1) print(c);     // La `expreOp' del `for'
                                  // debe ser de tipo simple"
  
  b = ((a[2] > 0) && true) || c;  // Error en "expresion logica"
  b = a[7] == b;                  // Error en "expresion de igualdad"
  b = ! (a[2] * 10);              // Error en "expresion unaria"
  if (a[7] < b )                  // Error en "expresion de relacional"
    a[7] = c;
  else {}
  
  return 0;
}
