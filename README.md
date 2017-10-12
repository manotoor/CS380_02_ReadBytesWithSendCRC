# CS380_02_ReadBytesWithSendCRC
Description
1. Create a Java source ﬁle1 named Ex2Client.java with a class named Ex2Client that contains the main method. You can also create any other classes or ﬁles as needed.
2. Your program should create a Socket connection to codebank.xyz port number 38102.
3. In this program, I will send you 100 bytes, however I will only send half of a byte each time. For example, if one of the 100 bytes has value 0x5A, I would send you two bytes with values 0x05 and 0x0A. 1If you want to use a diﬀerent language, let me know.
1
4. For each of the 100 bytes I send, read from the InputStream twice and put the two pieces together to form a single byte. Using the previous example, I sent you 0x05 and 0x0A. You should create from this the byte value 0x5A.
5. After reconstructing the 100 byte message, use Java’s java.util.zip.CRC32 class to generate a CRC32 error code for the 100 bytes.
6. Send this CRC code as a sequence of four bytes back to the server.
7. If the server constructs the same CRC32 code as you, it will then respond with a single byte having value 1, otherwise it will respond with a byte having value 0
