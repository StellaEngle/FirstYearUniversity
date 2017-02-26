; ----- Task 9 ------- COUNTING AND JUMP -------------------------------------

	CLO		; Close unwanted windows.
	MOV	BL,1	; Initial value stored in BL

Rep:			; Jump back to this label
	MUL	BL,2	; Multiply TWO with BL
	JMP	Rep	; Jump back to Rep. Press escape to stop the program

	END		; Program Ends

; ===== Program Ends =========================================================