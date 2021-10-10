# experisLesson1
advanced Java programinhg

Vertual machine with the flowing capebileties 

Stack: 32 int
 
 Register file: 2 registers:
     -  ax
     -  bx
     
 Instruction set:
 
 -      opcode              description
 _____________________________________
-     0                 push ax --> top stack
-     1                 pop ax <-- top stack
-     2                 mov ax, bx
-     3                 mov bx, ax
-     4                 load data ax <-- data
-     5                 add ax <- ax + bx
-     6                 sub ax <- ax - bx
-     7                 mul ax <- ax * bx
-     8                 div ax <- ax / bx
-     9                 jmp offset goto here + offset and continue from there
-     10                jmz offset do the jump iff ax == 0
-     11                print println(ax)

 starting state: stack is empty ax, bx are zeroed

 implement the virtual machine
 write small programs:
 
-       print all numbers from 1 to 32
 
-      calculate 7!

