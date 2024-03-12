/* Creencias iniciales */
fact(0,1).

/* Planes */
+fact(X,Y) : X < 100
  <-   +fact(X+1,  (X+1) * Y ).

+fact(X,Y) : X = 100
  <-   .print("fact 5 == ", Y ).
