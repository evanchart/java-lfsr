# java-lfsr
Left Feedback Shift Register implemented in JavaSE 13

In-place string obfuscation.
 - Shifts all of the bits on position to the left.
 - Replaces the vacated bit by XOR of the bit shifted off and the bit at a given tap position in the register.
 - TAP position uses 0xB400u, which has bits 16, 14, 13, and 11 -- Fibonacci LFSR.

Message retrieved by same method of obfuscation.
