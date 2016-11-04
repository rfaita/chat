package chat.entity {
	import mx.collections.ArrayCollection;

	public class ChatRoom 	{
		
		public var id:int;
		public var idSAC:int;
		public var nome:String;
		public var usuarios:Array;
		public var usuariosOffline:Array;
		public var history:Array;
		public var open:Boolean = false;
		
		public function ChatRoom()	 {
		}
	}
}