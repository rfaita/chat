package chat.core.message.impl {
	import com.adobe.serialization.json.JSON;
	
	import chat.core.message.Message;
	import chat.entity.Usuario;

	public class MessageImpl implements Message {
		
		public var type:String;
		public var usuario:Usuario;
		public var time:Number = new Date().getTime();
		
		public function MessageImpl(type:String, usuario:Usuario) {
			this.type = type;
			this.usuario = usuario;
		}
		
		public function asJSON():String {
			return JSON.encode(this);
		}
	}
}