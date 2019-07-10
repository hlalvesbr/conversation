package org.iadb.conversation.chat

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Message(var id: Int = 0,
                   var chat_id: Int = 0,
                   var from: String = "",
                   var text: String = "",
                   var sent_by_user: Boolean = false,
                   var created_at: Date = Date(),
                   var sensitive_information_type: String? = null,
                   var sensitive_information_data: String? = null,
                   var sensitive_information_id: Int? = null) {


}