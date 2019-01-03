package galacticgames.android.skilltree.common.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.screens.common.views.BaseViewMvc;


public class ToolbarViewMvc extends BaseViewMvc {

    public interface NavigateUpClickListener {
        void onNavigateUpClicked();
    }

    public interface HamburgerClickListener {
        void onHamburgerClicked();
    }

    public interface HomeClickListener {
        void onHomeClicked();
    }

    public interface SaveClickListener {
        void onSaveClicked();
    }

    public interface AddClickListener {
        void onAddClicked();
    }

    private final TextView mTxtTitle;
    private final ImageButton mBtnBack;
    private final ImageButton mBtnHamburger;
    private final ImageButton mBtnHome;
    private final ImageButton mBtnSave;
    private final ImageButton mBtnAdd;

    private NavigateUpClickListener mNavigateUpClickListener;
    private HamburgerClickListener mHamburgerClickListener;
    private HomeClickListener mHomeClickListener;
    private SaveClickListener mSaveClickListener;
    private AddClickListener mAddClickListener;

    public ToolbarViewMvc(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_common_toolbar, parent, false));
        mTxtTitle = findViewById(R.id.txt_toolbar_title);
        mBtnHamburger = findViewById(R.id.btn_hamburger);
        mBtnHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHamburgerClickListener.onHamburgerClicked();
            }
        });
        mBtnBack = findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNavigateUpClickListener.onNavigateUpClicked();
            }
        });
        mBtnHome = findViewById(R.id.btn_home);
        mBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHomeClickListener.onHomeClicked();
            }
        });
        mBtnSave = findViewById(R.id.btn_save);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSaveClickListener.onSaveClicked();
            }
        });
        mBtnAdd = findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAddClickListener.onAddClicked();
            }
        });
    }

    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }

    public void enableHamburgerButtonAndListen(HamburgerClickListener hamburgerClickListener) {
        if (mHomeClickListener != null && mNavigateUpClickListener != null) {
            throw new RuntimeException("Home, hamburger, and up shouldn't be shown together");
        }
        mHamburgerClickListener = hamburgerClickListener;
        mBtnHamburger.setVisibility(View.VISIBLE);
    }

    public void enableUpButtonAndListen(NavigateUpClickListener navigateUpClickListener) {
        if (mHamburgerClickListener != null && mHomeClickListener != null) {
            throw new RuntimeException("Home, hamburger, and up shouldn't be shown together");
        }
        mNavigateUpClickListener = navigateUpClickListener;
        mBtnBack.setVisibility(View.VISIBLE);
    }

    public void enableHomeButtonAndListen(HomeClickListener homeClickListener) {
        if (mHamburgerClickListener != null && mNavigateUpClickListener != null) {
            throw new RuntimeException("Home, hamburger, and up shouldn't be shown together");
        }
        mHomeClickListener = homeClickListener;
        mBtnHome.setVisibility(View.VISIBLE);
    }

    public void enableSaveButtonAndListen(SaveClickListener saveClickListener) {
//        TODO: if (mBtnAdd != null) {
//            throw new RuntimeException("Add and save shouldn't be shown together");
//        }
        mSaveClickListener = saveClickListener;
        mBtnSave.setVisibility(View.VISIBLE);
    }

    public void enableAddButtonAndListen(AddClickListener addClickListener) {
//        TODO: if (mBtnSave != null) {
//            throw new RuntimeException("Add and save shouldn't be shown together");
//        }
        mAddClickListener = addClickListener;
        mBtnAdd.setVisibility(View.VISIBLE);
    }

}
