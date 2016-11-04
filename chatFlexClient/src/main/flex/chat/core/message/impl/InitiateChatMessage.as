package chat.core.message.impl {
	import chat.core.message.Message;
	import chat.core.message.impl.MessageImpl;
	import chat.entity.ChatRoom;
	import chat.entity.Usuario;

	public class InitiateChatMessage extends MessageImpl implements Message {
		
		public var chat:ChatRoom;
		
		public function InitiateChatMessage(u:Usuario, chat:ChatRoom = null)	{
			super("chat.core.message.impl.InitiateChatMessage", u);
			this.chat = chat;
		}
	}
}