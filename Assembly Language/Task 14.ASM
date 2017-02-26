; ----- Task 14 ------- PROCEDURES ------------------------------

; ---------------------------------------------------------------

;  A general purpose time delay procedure.

;  The delay is controlled by the value in AL.

;  When the procedure terminates, the CPU registers are
;  restored to the same values that were present before 
;  the procedure was called. Push, Pop, Pushf and Popf
;  are used to achieve this.  In this example one procedure 

;  is re-used four times.  This re-use is one of the main 
;  advantages of using procedures.

;------ The Main Program ----------------------------------------
Start:
	
			; Turn on Red and Green traffic lights.
	MOV 	AL,84	; Copy 10000100 into the AL register.
	OUT 	01	; Send AL to Port One (The traffic lights).
	MOV 	AL,8
	CALL 	30
			; Turn on Red-Ambrer and Amber traffic lights.
	MOV 	AL,C8	; Copy 11001000 into the AL register.
        OUT 	01	; Send AL to Port One (The traffic lights).
	MOV 	AL,5
	CALL 	30	
			; Turn on Green and Red traffic lights.
	MOV 	AL,30	; Copy 00110000 into the AL register.
	OUT 	01	; Send AL to Port One (The traffic lights).
	MOV 	AL,8
	CALL 	30
			; Turn on Amber and Red-Amber traffic lights.
	MOV 	AL,58	; Copy 01011000 into the AL register.
	OUT 	01	; Send AL to Port One (The traffic lights).
	MOV 	AL,5
	CALL 	30
	

	JMP	Start	; Jump back to the start.

; ----- Time Delay Procedure Stored At Address [30] -------------
	ORG	30	; Generate machine code from address [30]

	PUSH	AL	; Save AL on the stack.
	PUSHF		; Save the CPU flags on the stack.
Rep:
	DEC	AL	; Subtract one from AL.
	JNZ	REP	; Jump back to Rep if AL was not Zero.

	POPF		; Restore the CPU flags from the stack.
	POP	AL	; Restore AL from the stack.

	RET		; Return from the procedure.
; ---------------------------------------------------------------
	END
; ---------------------------------------------------------------