; ----- Task 8 ------- COUNTING AND JUMP ---------------------------------------

	CLO		; Close unwanted windows.
	MOV	BL,40	; Initial value stored in BL

Rep:			; Jump back to this label
	ADD	BL,3	; Add THREE to BL
	JMP	Rep	; Jump back to Rep. Press escape to stop the program

	END		; Program Ends

; ===== Program Ends ==========================================================