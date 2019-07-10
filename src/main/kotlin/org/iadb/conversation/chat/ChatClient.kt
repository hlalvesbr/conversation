package org.iadb.conversation.chat

import java.util.*

interface ChatClient {

    fun searchConversations(botID: Int, startDate: String, endDate: String): List<Conversation>

    fun searchMessages(botID: Int, conversationID: Int): List<Message>
}