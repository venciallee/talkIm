package com.talk.enumeration;

import com.talk.R;

public enum ePagerSelected {
	CHAT {
		public int contentLayoutID() {
			return R.layout.chat_views;
		}

		@Override
		public int desScrollViewID() {
			return R.id.chatContent;
		}

		@Override
		public int desParentLayouID() {
			return R.id.chatContentLayout;
		}
	},
	CONTACT {
		@Override
		public int contentLayoutID() {
			return R.layout.contact_views;
		}

		@Override
		public int desScrollViewID() {
			return R.id.friendContent;
		}

		@Override
		public int desParentLayouID() {
			return R.id.contactContentLayout;
		}
	},
	SEARCH {
		@Override
		public int contentLayoutID() {
			return 0;
		}

		@Override
		public int desScrollViewID() {
			return 0;
		}

		@Override
		public int desParentLayouID() {
			return 0;
		}
	};

	abstract public int contentLayoutID();
	//目标scroolView的ID。
	abstract public int desScrollViewID();
	//目标父layout的ID.
	abstract public int desParentLayouID();
}
