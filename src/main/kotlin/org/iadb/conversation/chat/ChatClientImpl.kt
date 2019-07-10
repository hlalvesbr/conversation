package org.iadb.conversation.chat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ChatClientImpl(@Value("\${chat.url}") val chatURL: String,
                     @Value("\${assistant.token}") val assistantToken: String,
                     @Value("\${organization.token}") val organizationToken: String,
                     @Autowired val restTemplate: RestTemplate) : ChatClient {

    override fun searchConversations(botID: Int, startDate: String, endDate: String): List<Conversation> {
        val httpHeaders = HttpHeaders()
        httpHeaders.add("Authorization", "Token token=${assistantToken}")
        val httpEntity = HttpEntity<Any>(httpHeaders)
        
        val conversations = restTemplate.exchange(chatURL + "/api/v1/bots/${botID}/chats/simple_list.json?organization_token=${organizationToken}&start_date=${startDate}&end_date=${endDate}&recent_than=",
                HttpMethod.GET, httpEntity, Array<Conversation>::class.java).body

        return if (conversations != null) conversations.asList() else listOf()
    }

    override fun searchMessages(botID: Int, conversationID: Int): List<Message> {
        val httpHeaders = HttpHeaders()
        httpHeaders.add("Authorization", "Token token=${assistantToken}")
        val httpEntity = HttpEntity<Any>(httpHeaders)

        val messages = restTemplate.exchange(chatURL + "/api/v1/bots/${botID}/chats/${conversationID}/messages?organization_token=${organizationToken}",
                HttpMethod.GET, httpEntity, Array<Message>::class.java).body

        return if (messages != null) messages.asList() else listOf()
    }
}