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
					System.out.print("\n");
				System.out.printf("%02X", message[i]);
			}

			//convert to hex characters
			// Print out bytes in hex
			System.out.print("Received bytes:");
			for (int i = 0; i < message.length; i++) {
				System.out.print(byteMessage[i]);
			}
			//Make crc code

			//Send this CRC code as a sequence of four bytes back to the server.

			//read response from server
			//if good print good response
			//else print not good

		}catch(Exception e){
			System.out.println("Could not connect to server");
		}
		System.out.println("Disconnected from server.");
	}
}