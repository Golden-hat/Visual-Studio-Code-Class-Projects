###############################################################################
OBJS = lex.c
#
cmc:	$(OBJS)  
	gcc -Wall -I./include $(OBJS) -lfl -o cmc
lex.c:	src/lex.l 
	flex -olex.c src/lex.l 

clean:
	rm -f ./lex.c ./asin.c ./asin.h ./*.o  ./include/asin.h ./*~
###############################################################################
