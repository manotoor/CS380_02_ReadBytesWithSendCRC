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
			//store first half and then push to left
			//read second half
			//add bytes

			//convert to hex characters

			//Make crc code

			//Send this CRC code as a sequence of four bytes back to the server.

			//read response from server
			//if good print good response
			//else print not good

		}catch(Exception e){
			System.out.println("Could not connect to server");
		}
		socket.close();
	}
}