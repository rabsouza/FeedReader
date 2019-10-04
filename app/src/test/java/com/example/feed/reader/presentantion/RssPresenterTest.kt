package com.example.feed.reader.presentantion

import com.example.feed.reader.gateway.RssGateway
import com.example.feed.reader.model.RssDto
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RssPresenterTest {

    @MockK
    lateinit var gateway: RssGateway

    @MockK
    lateinit var view: RssContract.View

    @InjectMockKs
    lateinit var presenter: RssPresenter

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)

    @Test
    fun `onStart - carrega os dados e exibe na telas`() {
        every { runBlocking { gateway.readerRss() } } returns mockk()

        presenter.onStart()

        verify { runBlocking { gateway.readerRss() } }
        verify { view.showItems(any() as List<RssDto>) }
    }

    @Test
    fun `onLoad - carrega os dados e exibe na telas`() {
        every { runBlocking { gateway.readerRss() } } returns mockk()

        presenter.onLoad()

        verify { runBlocking { gateway.readerRss() } }
        verify { view.showItems(any() as List<RssDto>) }
    }

    @Test
    fun `onViewMoreClick - abre link do feed`() {
        presenter.onViewMoreClick(mockk())

        verify { view.openViewMoreItem(any()) }
    }


}