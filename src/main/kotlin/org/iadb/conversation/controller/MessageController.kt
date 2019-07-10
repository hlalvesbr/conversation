package org.iadb.conversation.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.iadb.conversation.chat.ChatClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestParam

@Controller
open class MessageController(@Autowired val chatClient: ChatClient) {
    
	@RequestMapping("/messages", method = [RequestMethod.GET])
    open fun show(@RequestParam("conv_id") conversationId:Int, form: MessageForm): ModelAndView {
        form.botID = 2
        form.conversationId = conversationId
        form.messages = chatClient.searchMessages(form.botID, form.conversationId)

        val modelAndView = ModelAndView("messages")
        modelAndView.addObject("form", form)
        return modelAndView
    }
	
	@RequestMapping("/messages", method = [RequestMethod.POST])
    fun search(form: MessageForm): ModelAndView {
        form.messages = chatClient.searchMessages(form.botID, form.conversationId)

        val modelAndView = ModelAndView("messages")
        modelAndView.addObject("form", form)
        return modelAndView
    }
}