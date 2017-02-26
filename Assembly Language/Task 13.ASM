; ----- Task 13 ------- CHARACTER INPUT OUTPUT --------------------------

; -----------------------------------------------------------------------
;  Input key presses from the keyboard until Enter is pressed.
; -----------------------------------------------------------------------	

	CLO		; Close unwanted windows.
	MOV	BL,A0	; Make BL point to RAM location A0.
	
Rep:
	IN	00	; Wait for key press - Store it in AL.	
	MOV 	[BL],AL	; Copy AL to the address that BL points to.
 	INC 	BL	; Make BL point to the next RAM location.
	CMP	AL,0D	; Was it the Enter key? (ASCII 0D)
	JNZ	Rep	; No - jump back.  Yes - end.
		
	MOV	CL,C0	; Make CL point to video RAM.
	MOV	BL,A0	; Make BL point to RAM location A0.

Display:
 	MOV 	AL,[BL]	; Copy the RAM location that BL points into AL regiter.
	MOV	[CL],AL	; Copy the value in AL to the RAM.	
	INC	CL	; Make CL point to the next RAM location.
	INC 	BL	; Make BL point to the next RAM location.
	CMP 	AL,0D	; Was it the Enter key? (ASCII 0D)
	JNZ 	Display ; No- jump back to Display. Yes -end.
END
;-------------------------------------------------------------
