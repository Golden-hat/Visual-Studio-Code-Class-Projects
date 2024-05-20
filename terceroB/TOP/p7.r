library(lpSolveAPI)
modelo <- make.lp(0, 3) 
set.objfn(modelo, c(1,9,3)) 
add.constraint(modelo, c(1,2,3),">=",1) 
add.constraint(modelo, c(3,2,2),"<=",15) 
lp.control(modelo, sense="max") 
 
colNames<-c("x1","x2","x3") 
rowNames<-c("res1","res2") 
dimnames(modelo)<-list(rowNames,colNames)

 
solve(modelo) 
get.objective(modelo) 
get.variables(modelo) 
get.constraints(modelo) 
 
 
get.dual.solution(modelo) 
get.sensitivity.obj(modelo) 
get.sensitivity.rhs(modelo) 