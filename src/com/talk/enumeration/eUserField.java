package com.talk.enumeration;

import com.talk.R;

public enum eUserField {

	PHOTO {
		public String getValue() {
			return "PROFILEPHOTO";
		}

		@Override
		public int getKey() {
			return R.id.profilePhoto_img_view;
		}
	},
	WHATUP {
		public String getValue() {
			return "WHATUP";
		}

		@Override
		public int getKey() {
			return R.id.whatUp_text_view;
		}
	},
	NICKNAME {
		public String getValue() {
			return "NICKNAME";
		}

		@Override
		public int getKey() {
			return R.id.nickName_text_view;
		}
	},
	CITY {
		public String getValue() {
			return "CITY";
		}

		@Override
		public int getKey() {
			//unimplement
			return 0;
		}
	},
	COLLEGE {
		public String getValue() {
			return "COLLEGE";
		}

		@Override
		public int getKey() {
			//unimplement
			return 0;
		}
	},
	SEX {
		public String getValue() {
			//unimplement
			return "SEX";
		}

		@Override
		public int getKey() {
			return 0;
		}
	},
	
	USERNAME{

		@Override
		public int getKey() {
			return 0;
		}

		@Override
		public String getValue() {
			return "userName";
		}
		
	};

	public abstract int getKey();
	
	public abstract String getValue();
}
