package org.iadb.conversation.controller

import org.iadb.conversation.chat.Message

class MessageForm(var botID: Int = 0,
				  var conversationId: Int = 0,
				  var messages: List<Message> = listOf()) {
}