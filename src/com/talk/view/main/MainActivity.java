package com.talk.view.main;

import java.util.Iterator;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.talk.R;
import com.talk.factory.XmppConnectionFactory;
import com.talk.handler.PagerSwitcherHandler;
import com.talk.message.OffLineMessage;
import com.talk.view.service.ViewPagerService;
import com.talk.view.service.ViewService;

public class MainActivity extends Activity {

	private ImageButton chatButton = null;
	private ImageButton friendButton = null;
	private ImageButton searchButton = null;
	private ViewService viewService = null;
	private ViewPager contentPager = null;
	private int currIndex = 0;
	private ImageView selected_bg_view = null;
	private ImageButton[] imageBtns = null;
	private int unselected_img_draws[] = { R.drawable.chat_font_btn,
			R.drawable.friend_font_btn, R.drawable.search_font_btn };
	private int selected_img_draws[] = { R.drawable.chat_font_btn_selected,
			R.drawable.friend_font_btn_selected,
			R.drawable.search_font_btn_selected };
	private ViewPagerService viewPagerService = null;

	private PagerSwitcherHandler mPagerHandler = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		imageBtns = new ImageButton[3];
		chatButton = (ImageButton) findViewById(R.id.chatButton);
		friendButton = (ImageButton) findViewById(R.id.friendButton);
		searchButton = (ImageButton) findViewById(R.id.searchButton);
		imageBtns[0] = chatButton;
		imageBtns[1] = friendButton;
		imageBtns[2] = searchButton;
		selected_bg_view = (ImageView) findViewById(R.id.selected_bg_view);
		selected_bg_view.layout(130, 130, 250, 250);
		chatButton.setOnClickListener(new ButtonOnClickListener(0));
		friendButton.setOnClickListener(new ButtonOnClickListener(1));
		searchButton.setOnClickListener(new ButtonOnClickListener(2));
		viewService = new ViewService();

		mPagerHandler = new PagerSwitcherHandler(this);

		viewPagerService = new ViewPagerService(mPagerHandler);
		
		selected_bg_view = viewPagerService.initImageView(this);

		contentPager = viewPagerService.initViewPager(this, currIndex,
				selected_bg_view, imageBtns, unselected_img_draws,
				selected_img_draws, viewService);

	}

	/**
	 * @author ven
	 * @createTime 2013-1-29上午12:41:02
	 * @lastEditTime 2013-1-29上午12:41:02
	 * @copyright Design by vencial
	 * @description 类描述
	 */
	private class ButtonOnClickListener implements OnClickListener {

		private int index = 0;

		public ButtonOnClickListener(int index) {
			this.index = index;
		}

		@Override
		public void onClick(View view) {
			ImageButton imageButton = (ImageButton) view;
			if (viewService.compareViewId(imageButton, R.id.chatButton)) {
				viewService.reverse(imageButton,
						R.drawable.chat_font_btn_selected, friendButton,
						R.drawable.friend_font_btn, searchButton,
						R.drawable.search_font_btn);
			} else if (viewService
					.compareViewId(imageButton, R.id.friendButton)) {
				viewService.reverse(imageButton,
						R.drawable.friend_font_btn_selected, chatButton,
						R.drawable.chat_font_btn, searchButton,
						R.drawable.search_font_btn);
			} else if (viewService
					.compareViewId(imageButton, R.id.searchButton)) {
				viewService.reverse(imageButton,
						R.drawable.search_font_btn_selected, chatButton,
						R.drawable.chat_font_btn, friendButton,
						R.drawable.friend_font_btn);
			}
			contentPager.setCurrentItem(index);
		}
	}

	/**
	 * @explain 获取离线消息，并把离线消息在主页面显示.
	 */
	private void setOffLineMsg() {
		XMPPConnection xmppCon = XmppConnectionFactory.getXmppConnection();
		OffLineMessage offLineMessage = new OffLineMessage();
		Iterator<Message> msg_Iterator = offLineMessage
				.getMsgIterator(offLineMessage.getOffLineMsgManager(xmppCon));
		while (msg_Iterator.hasNext()) {
			Message msg = msg_Iterator.next();
			msg.getFrom();
		}
	}

}
