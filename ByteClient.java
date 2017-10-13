/*
 *	Mano Toor
 *	Exercise 2
 *  Read 200 bytes, 100 bytes at a time and create a CRC32 and check to make sure receiving proper message
 */
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;

public class ByteClient{
	public static void main(String[] args){

		byte[] message = new byte[100];

		try(Socket socket = new Socket("18.221.102.182",38102)){
			System.out.println("Connected to Server");

			//Input Output for server
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			//CRC error code from server
			CRC32 crc = new CRC32();

			//Read byte by byte
			for(int i =0; i < message.length;i++){
				//store first half and then push to left
				byte left = (byte)is.read();
				//read second half
				byte right = (byte)is.read();
				//shift over 4 bits
				left = (byte)(left << 4);
				//add bytes
				message[i] = (byte)(left + right);
			}

			//convert to hex characters
			// Print out bytes in hex
			System.out.print("Received bytes:");
			for (int i = 0; i < message.length; i++) {
				if(i%10 == 0)
					System.out.print("\n\t");
				System.out.printf("%02X", message[i]);
			}
			//Make crc code
			crc.update(message);
			long error = crc.getValue();
			System.out.printf("%nGenerated CRC32: %02X",error);
			//Send this CRC code as a sequence of four bytes back to the server.
			for(int i =3; i >=0;i--){
				os.write((int)error >> (8*i));
			}
			//read response from server
			//if good print good response
			if(is.read() == 1){
				System.out.println("\nResponse good.");
			}
			//else print not good
			else if (is.read() == 0){
				System.out.println("\nResponse bad.");
			}

		}catch(Exception e){
			System.out.println("Could not connect to server");
		}
		System.out.println("Disconnected from server.");
	}
}