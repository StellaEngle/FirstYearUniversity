; ----- EXAMPLE 9 ------- Text I/O -------------------

; --------------------------------------------------------------
; A program to read in a string of text and store it in RAM.
; The end of text will be labelled with ASCII code zero/null.
; --------------------------------------------------------------
; THE MAIN PROGRAM

	MOV	BL,70	; [70] is the address where the text will
			; be stored. The procedure uses this.

	CALL	10	; The procedure at [10] reads in text and
			; places it starting from the address
			; in BL.

			; BL should still contain [70] here.

	CALL	90	; The procedure at [30] convert any 
			; uppercase letters to lowercase letters.

	CALL	40	; The procedure at [40] displays the text.
	

	HALT		; DON'T USE "END" HERE BY MISTAKE OR THE CODE
    			; FOR THE PROCEDURES WILL NOT BE GENERATED
                
; --------------------------------------------------------------
; A PROCEDURE TO READ IN THE TEXT
	ORG	10	; Code starts from address [10]

	PUSH	AL	; Save AL onto the stack
	PUSH	BL	; Save BL onto the stack
	PUSHF		; Save the CPU flags onto the stack

Rep:
	IN	00	; Input from port 00 (keyboard)
	CMP	AL,0D	; Was key press the Enter key?
	JZ	Stop	; If yes then jump to Stop
	MOV	[BL],AL	; Copy keypress to RAM at position [BL]
	INC	BL	; BL points to the next location.
	JMP	Rep	; Jump back to get the next character

Stop:
	MOV	AL,0	; This is the NULL end marker
	MOV	[BL],AL	; Copy NULL character to this position.

	POPF		; Restore flags from the stack
	POP	BL	; Restore BL from the stack
	POP	AL	; Restore AL from the stack

	RET		; Return from the procedure.
;---------------------------------------------------------------
; A PROCEDURE TO CONVERT UPPER CASE LETTERS TO LOWER CASE LETTERS
	ORG	90	; Code starts from address [30]	
	
	PUSH	AL	; Save AL onto the stack
	PUSH	BL	; Save BL onto the stack
	PUSHF		; Save the CPU flags onto the stack
	
	
Case:
	MOV	AL,[BL]	; Copy the RAM location that BL points into AL regiter.			
	CMP	AL,00	; Was it the Enter key?
	JZ	Last	; Yes - jump to Last.  No - continue.
	
	CMP	AL,61	; If value in AL bigger than 61(ASCII value)
	JS	Convert	; Yes - jump to Convert. No - continue.

	INC 	BL	; Make BL point to the next RAM location.
	JNS	Case	; No - jump back. Yes - continue.

Convert:	
	ADD	AL,20	; ADD 20 to AL register.
	MOV	[BL],AL	; Copy the value in AL to the RAM location that 
			; BL points to.
	INC 	BL	; Make BL point to the next RAM location.	
	JMP	Case	; Jump back to Case to get next character

Last:
	POPF		; Restore flags from the stack
	POP	BL	; Restore BL from the stack
	POP	AL	; Restore AL from the stack
	
	RET		; Return from the procedure.
	

; --------------------------------------------------------------
; A PROCEDURE TO DISPLAY TEXT ON THE SIMULATED SCREEN
	ORG	40	; Code starts from address [40]	
	
	MOV	CL,C0	; Make CL point to video RAM.
	PUSH	AL	; Save AL onto the stack
	PUSH	BL	; Save BL onto the stack
	PUSHF		; Save the CPU flags onto the stack
	
Display:	
	MOV 	AL,[BL] ; Copy the RAM location that BL points into AL regiter.
	MOV	[CL],AL	; Copy the value in AL to the RAM location that 
			; CL points to.
	INC	CL	; Make CL point to the next RAM location.
	INC	BL	; Make BL point to the next RAM location.
	CMP	AL,00	; Was it the Enter key?
	JNZ	Display	; No - jump back. Yes - continue.
	
	POPF		; Restore flags from the stack
	POP	BL	; Restore BL from the stack
	POP	AL	; Restore AL from the stack	
			
	RET		; Return from the procedure.

	
; --------------------------------------------------------------
	END		; It is correct to use END at the end.
; --------------------------------------------------------------