; ----- Task 12 ------- CHARACTER INPUT OUTPUT --------------------------

; -----------------------------------------------------------------------
;  Input key presses from the keyboard until Enter is pressed.
; -----------------------------------------------------------------------
	CLO		; Close unwanted windows.
	MOV 	BL, C0	; Make BL point to video RAM.
Rep:
	IN	00	; Wait for key press - Store it in AL.		
	MOV 	[BL],AL	; Copy AL to the address that BL points to.
	INC 	BL	; Make BL point to the next video RAM location	
	CMP	AL,0D	; Was it the Enter key? (ASCII 0D)
	JNZ	Rep	; No - jump back.  Yes - end.
	

END
; --------------------------------------------------------------
