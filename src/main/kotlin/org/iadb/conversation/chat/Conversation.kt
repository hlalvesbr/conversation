package org.iadb.conversation.chat

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Conversation(var id: Int = 0,
                        var bot_id: Int? = null,
                        var user_identifier: String = "",
                        var user_name: String? = null,
                        var auto: Boolean = true,
                        var updated_at: Date = Date(),
                        var created_at: Date = Date(),
                        var service_name: String = "",
                        var facebook_page_id: Int? = null,
                        var is_active: Boolean = true,
                        var desk_comment: String? = null,
                        var desk_tag: String? = null,
                        var user_email: String? = null,
                        var third_party_token: String? = null,
                        var operator_name: String? = null,
                        var operator_avatar: String? = null,
                        var operator_custom_id: Int? = null,
                        var organization_id: Int = 0,
                        var conversable_id: Int = 0,
                        var user_ip: String = "",
                        var messages: List<Message> = listOf()) {

}