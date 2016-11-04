package chat.core.message.impl {
	import chat.core.message.Message;
	import chat.entity.Usuario;

	public class InitiatedChatMessage extends MessageImpl implements Message {
		
		public var chats:Array; 
		
		public function InitiatedChatMessage(u:Usuario)	{
			super("chat.core.message.impl.InitiatedChatMessage", u);
		}
	}
}