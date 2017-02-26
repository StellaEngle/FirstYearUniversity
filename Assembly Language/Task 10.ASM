; ----- Task 10 ------- COUNTING AND JUMP ---------------------------------------

	CLO		; Close unwanted windows.
	MOV	BL,0	; Initial value stored in BL
	MOV	CL,1	; Initial value stored in CL 

Rep:			; Jump back to this label
	MOV	[B0],BL ; Copy the value in BL to RAM location [B0].
	ADD	Bl,CL	; Add the value in CL to BL.	
	ADD	CL,BL	; Add the value in BL to CL.
	
	JMP Rep		; Jump back to Rep. Press escape to stop the program


	END		; Program Ends

; ===== Program Ends ============================================================