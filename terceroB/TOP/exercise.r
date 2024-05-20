library(lpSolveAPI)
modelo <- make.lp(0, 5) 
aij <- matrix(c(1, 0, 0, 0, 0, 0, 1, 1, 0,0, 0, 0, 0, 1, 1, 10, 8, 0, 8, 0, 0, 0, 6, 0, 10, 6, 10, 0, 16, 3, 3, 0, 9, 0, 8), nrow=7, byrow=TRUE) 
ci <- c(634, 560, 570, 704, 812) 
bi <- c(480, 480, 480, 480)
set.objfn(modelo, ci) 
add.constraint(modelo, aij[1,],">=", 36) 
add.constraint(modelo, aij[2,],">=", 45) 
add.constraint(modelo, aij[3,],">=", 10) 
add.constraint(modelo, aij[4,],"<=",bi[1]) 
add.constraint(modelo, aij[5,],"<=",bi[2]) 
add.constraint(modelo, aij[6,],"<=",bi[3]) 
add.constraint(modelo, aij[7,],"<=",bi[4]) 

modelo
 
solve(modelo) 
get.objective(modelo) 
get.variables(modelo) 
get.constraints(modelo) 
 
 
get.dual.solution(modelo) 
get.sensitivity.obj(modelo) 
get.sensitivity.rhs(modelo)

write.lp(modelo,'modelo.mps',type="mps") 