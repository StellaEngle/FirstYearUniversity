; ----- Task 15 ------- Passing Parameters ---------------------------

; ----- Using a register to pass the parameter into a procedure ------

	JMP 	Start	; Skip over bytes used for data storage

	DB	0	; Reserve a byte of RAM at address [02]
	DB	0	; Reserve a byte of RAM at address [03]
Start:
	MOV	AL,5	; Copy value into AL register
	
	CALL	30	; A procedure to double AL
			; Result returned in AL.
	
; ----- A procedure to double a number ---------------------------------

;	Parameter passed into procedure using register AL 
;	Result returned in AL

	ORG	30	; Code starts at address [30]

	MUL	AL,2	; Do the multiplication.  Result goes into AL
	RET		


; --------------------------------------------------------------
	END