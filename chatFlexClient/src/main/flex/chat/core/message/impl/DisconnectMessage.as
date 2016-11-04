package chat.core.message.impl {
	import chat.core.message.Message;
	import chat.entity.Usuario;

	public class DisconnectMessage extends MessageImpl implements Message {
		
		public function DisconnectMessage(u:Usuario)	{
			super("chat.core.message.impl.DisconnectMessage", u);
		}
	}
}