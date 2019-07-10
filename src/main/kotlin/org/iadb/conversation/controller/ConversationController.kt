package org.iadb.conversation.controller

import org.iadb.conversation.chat.ChatClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
class ConversationController(@Autowired val chatClient: ChatClient) {

    @RequestMapping("/", method = [RequestMethod.GET])
    fun show(form: ConversationForm): ModelAndView {
        form.botID = 2
        form.startDate = "20181215"
        form.endDate = "20181231"
        form.conversations = listOf()

        val modelAndView = ModelAndView("conversations")
        modelAndView.addObject("form", form)
        return modelAndView
    }

    @RequestMapping("/", method = [RequestMethod.POST])
    fun search(form: ConversationForm): ModelAndView {
        form.conversations = chatClient.searchConversations(form.botID, form.startDate, form.endDate)

        val modelAndView = ModelAndView("conversations")
        modelAndView.addObject("form", form)
        return modelAndView
    }
}
