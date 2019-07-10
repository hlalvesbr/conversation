package org.iadb.conversation.controller

import org.iadb.conversation.chat.Conversation

data class ConversationForm(var botID: Int = 0,
                            var startDate: String = "",
                            var endDate: String = "",
                            var conversations: List<Conversation> = listOf()) {

}