package com.talk.view.listener;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.talk.enumeration.ePagerSelected;
import com.talk.handler.PagerSwitcherHandler;
import com.talk.thread.PagerSwitcherRunnable;
import com.talk.user.ContactService;
import com.talk.view.service.ViewService;

/**
 * @author ven
 * @createTime 2013-1-28下午11:44:04
 * @lastEditTime 2013-1-28下午11:44:04
 * @copyright Design by vencial
 * @description 类描述
 */
public class ContentPagerListener implements OnPageChangeListener {
	private int offset;
	private int bitMapWidth;
	// 一个单位的移动单元.
	private int one;
	// 两个单位的移动单元.
	private int two;
	private int currIndex;
	private ImageView selected_bg_view = null;
	private ImageButton[] imageBtns = null;
	private int unselected_img_draws[];
	private int selected_img_draws[];
	private ViewService viewService = null;

	// value为true时，表示已经更新所有聊天列表.
	// private boolean mCantactUpdateFlag = false;

	// value为true时，表示已经更新所有聊天列表.
	// private boolean mChatUpdatedFlag = false;

	private Activity mActivity = null;

	// 联系人resourse.
	//private Collection<RosterEntry> mRosterLists = null;

	private ContactService mContactService = null;
	// 聊天resourse.
	//private static final int LASTMSGVIEW = R.id.last_text_view;

	//private static final int LASTTIMEVIEW = R.id.time_text_view;

	// handler
	private PagerSwitcherHandler mHandler = null;

	public ContentPagerListener(Activity activity,
			ArrayList<View> viewGroupLists, Handler handler) {
		this.mActivity = activity;

		mContactService = new ContactService();

		// mMsgSharedPrefs = new MsgSharedPrefenrence(activity);

		this.mHandler = (PagerSwitcherHandler) handler;

		mHandler.setmViewGroupLists(viewGroupLists);

		mHandler.post(new PagerSwitcherRunnable(mContactService, mActivity, 0,
				mHandler, ePagerSelected.CHAT));

		/*
		 * mRosterLists = mContactService.getAllContacts();
		 * 
		 * this.mViewGroupLists = viewGroupLists;
		 * 
		 * loadView(mRosterLists, ePagerSelected.CHAT.contentLayoutID(),
		 * ePagerSelected.CHAT.desScrollViewID(),
		 * ePagerSelected.CHAT.desParentLayouID(), (ViewGroup)
		 * viewGroupLists.get(0), ePagerSelected.CHAT);
		 */
	}

	/**
	 * @explain 根据偏移量和目标位图的宽度生成移动的位置单元one和two.
	 * 
	 * @param offset
	 * @param bitMapWidth
	 * @param currIndex
	 */
	public ContentPagerListener(int offset, int bitMapWidth, int currIndex,
			Activity activity, ArrayList<View> viewGroupLists, Handler handler) {
		this(activity, viewGroupLists, handler);
		this.offset = offset;
		this.bitMapWidth = bitMapWidth;
		this.one = this.offset * 2 + this.bitMapWidth;
		this.two = this.one * 2;
		this.currIndex = currIndex;
	}

	/**
	 * 
	 * 
	 * @param offset
	 * @param bitMapWidth
	 * @param currIndex
	 * @param selected_bg_view
	 * @param imageBtns
	 * @param unselected_img_draws
	 * @param selected_img_draws
	 * @param viewService
	 */
	public ContentPagerListener(int offset, int bitMapWidth, int currIndex,
			ImageView selected_bg_view, ImageButton[] imageBtns,
			int unselected_img_draws[], int selected_img_draws[],
			ViewService viewService, Activity activity,
			ArrayList<View> viewGroupLists, Handler handler) {
		this(activity, viewGroupLists, handler);
		this.offset = offset;
		this.bitMapWidth = bitMapWidth;
		this.one = this.offset * 2 + this.bitMapWidth;
		this.two = this.one * 2;
		this.currIndex = currIndex;
		this.selected_bg_view = selected_bg_view;
		this.imageBtns = imageBtns;
		this.unselected_img_draws = unselected_img_draws;
		this.selected_img_draws = selected_img_draws;
		this.viewService = viewService;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		Animation anim = null;
		/*
		 * if (null != mViewGroupLists) { viewGroup = (ViewGroup)
		 * mViewGroupLists.get(arg0); }
		 */
		switch (arg0) {
		case 0:
			if (currIndex == 1) {
				anim = new TranslateAnimation(one, 0, 0, 0);
			} else if (currIndex == 2) {
				anim = new TranslateAnimation(two, 0, 0, 0);
			}
			new Thread(new PagerSwitcherRunnable(mContactService, mActivity,
					arg0, mHandler, ePagerSelected.CHAT)).start();

			/*
			 * mRosterLists = mContactService.getAllContacts();
			 * 
			 * loadView(mRosterLists, ePagerSelected.CHAT.contentLayoutID(),
			 * ePagerSelected.CHAT.desScrollViewID(),
			 * ePagerSelected.CHAT.desParentLayouID(), viewGroup,
			 * ePagerSelected.CHAT);
			 */
			break;
		case 1:
			if (currIndex == 0) {
				anim = new TranslateAnimation(offset, one, 0, 0);
			} else if (currIndex == 2) {
				anim = new TranslateAnimation(two, one, 0, 0);
			}
			
			new Thread(new PagerSwitcherRunnable(mContactService, mActivity,
					arg0, mHandler, ePagerSelected.CONTACT)).start();

			/*
			 * mRosterLists = mContactService.getAllContacts();
			 * 
			 * loadView(mRosterLists, ePagerSelected.CONTACT.contentLayoutID(),
			 * ePagerSelected.CONTACT.desScrollViewID(),
			 * ePagerSelected.CONTACT.desParentLayouID(), viewGroup,
			 * ePagerSelected.CONTACT);
			 */
			break;
		case 2:
			if (currIndex == 0) {
				anim = new TranslateAnimation(offset, two, 0, 0);
			} else if (currIndex == 1) {
				anim = new TranslateAnimation(one, two, 0, 0);
			}

			break;
		}
		viewService.reverse(imageBtns[arg0], selected_img_draws[arg0],
				imageBtns[currIndex], unselected_img_draws[currIndex]);
		currIndex = arg0;
		anim.setFillEnabled(true);
		anim.setFillAfter(true);
		anim.setDuration(300);
		selected_bg_view.startAnimation(anim);
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getBitMapWidth() {
		return bitMapWidth;
	}

	public void setBitMapWidth(int bitMapWidth) {
		this.bitMapWidth = bitMapWidth;
	}

	public int getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public int getTwo() {
		return two;
	}

	public void setTwo(int two) {
		this.two = two;
	}

	public int getCurrIndex() {
		return currIndex;
	}

	public void setCurrIndex(int currIndex) {
		this.currIndex = currIndex;
	}

	public ImageView getSelected_bg_view() {
		return selected_bg_view;
	}

	public void setSelected_bg_view(ImageView selectedBgView) {
		selected_bg_view = selectedBgView;
	}

	public ImageButton[] getImageBtns() {
		return imageBtns;
	}

	public void setImageBtns(ImageButton[] imageBtns) {
		this.imageBtns = imageBtns;
	}

	public int[] getUnselected_img_draws() {
		return unselected_img_draws;
	}

	public void setUnselected_img_draws(int[] unselectedImgDraws) {
		unselected_img_draws = unselectedImgDraws;
	}

	public int[] getSelected_img_draws() {
		return selected_img_draws;
	}

	public void setSelected_img_draws(int[] selectedImgDraws) {
		selected_img_draws = selectedImgDraws;
	}

	public ViewService getViewService() {
		return viewService;
	}

	public void setViewService(ViewService viewService) {
		this.viewService = viewService;
	}
}
