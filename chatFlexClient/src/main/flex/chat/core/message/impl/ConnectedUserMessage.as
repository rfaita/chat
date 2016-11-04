package chat.core.message.impl {
	import chat.core.message.Message;
	import chat.entity.Usuario;

	public class ConnectedUserMessage extends MessageImpl implements Message {
		
		public var usuarios:Array; 
		
		public function ConnectedUserMessage(u:Usuario)	{
			super("chat.core.message.impl.ConnectedUserMessage", u);
		}
	}
}