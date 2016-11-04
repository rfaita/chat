package chat.core.message.impl {
	import chat.core.message.Message;
	import chat.entity.Usuario;

	public class ConnectionMessage extends MessageImpl implements Message {
		
		
		public function ConnectionMessage(usuario:Usuario){
			super("chat.core.message.impl.ConnectionMessage", usuario);
		}
	}
}