package chat.core.message.impl {
	import chat.core.message.Message;
	import chat.entity.ChatRoom;
	import chat.entity.Usuario;
	
	public class TalkMessage extends MessageImpl implements Message {
		
		public var talk:String;
		public var chat:ChatRoom;
		
		public function TalkMessage(usuario:Usuario, chat:ChatRoom, talk:String) {
			super("chat.core.message.impl.TalkMessage", usuario);
			this.chat = chat;
			this.talk = talk;
		}
	}
}