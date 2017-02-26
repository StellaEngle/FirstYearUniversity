; ----- Task 7 ------- COUNTING AND JUMP ---------------------------------------

	CLO		; Close unwanted windows.
	MOV	BL,40	; Initial value stored in BL

Rep:			; Jump back to this label
	DEC	BL	; Substract ONE from BL
	JMP	Rep	; Jump back to Rep. Press escape to stop the program

	END		; Program Ends

; ===== Program Ends ===========================================================