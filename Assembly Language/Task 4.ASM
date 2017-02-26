; ----- TASK 4 ------- ARITHMETIC --------------------------------------------------------

; ===== WORK OUT 2 PLUS 2 ===================================================================
	CLO		; Close unwanted windows.
	MOV AL,2	; Copy a 2 into the AL register.
	MOV BL,0	; Copy a 0 into the BL register.
	DIV AL,BL	; Divide BL with AL. Answer goes into AL. An error message appears.
	END		; Program ends
; ===== Program Ends =======================================================================
