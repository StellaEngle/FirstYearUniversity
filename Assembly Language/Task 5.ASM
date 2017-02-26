; ===== TASK 5 ===========================================================
; ===== CONTROL THE TRAFFIC LIGHTS =======================================

	CLO		; Close unwanted windows.
Start:
			; Turn on Red and Green traffic lights.
	MOV AL,84	; Copy 10000100 into the AL register.
	OUT 01		; Send AL to Port One (The traffic lights).
			; Turn on Red-Ambrer and Amber traffic lights.
	MOV AL,C8	; Copy 11001000 into the AL register.
        OUT 01		; Send AL to Port One (The traffic lights).
			; Turn on Green and Red traffic lights.
	MOV AL,30	; Copy 00110000 into the AL register.
	OUT 01		; Send AL to Port One (The traffic lights).
			; Turn on Amber and Red-Amber traffic lights.
	MOV AL,58	; Copy 01011000 into the AL register.
	OUT 01		; Send AL to Port One (The traffic lights).
	JMP Start	; Jump back to the start.
	END		; Program ends.
	
; ===== Program Ends =====================================================