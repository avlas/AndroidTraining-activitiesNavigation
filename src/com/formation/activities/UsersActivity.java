package com.formation.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class UsersActivity extends Activity {

	static final int PICK_USER = 1;
	private ListView usersView;
	private User selectedUser;
	public static int selectedPosition = -1;
	private UserArrayAdapter adapter;
	private List<User> users;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_users);

		users = buildUsers();

		usersView = (ListView) findViewById(R.id.list_users);

		adapter = new UserArrayAdapter(usersView.getContext(), R.layout.activity_user_row, R.id.row_fullname, users);
		usersView.setAdapter(adapter);

		// ArrayAdapter adapter = new ArrayAdapter<User>(listUsers.getContext(),
		// R.layout.activity_user_list, R.id.user, users);

		addListenerOnList();
	}

	private List<User> buildUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("Tata", "Tete", R.drawable.nature));
		users.add(new User("Tete", "Titi", R.drawable.nature));
		users.add(new User("Titi", "Toto", R.drawable.nature));
		users.add(new User("Toto", "Tutu", R.drawable.nature));
		users.add(new User("Tutu", "Tata", R.drawable.nature));
		return users;
	}

	private void addListenerOnList() {
		usersView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
				selectedPosition = position;

				selectedUser = (User) adapter.getItem(position);

				Intent userIntent = new Intent(UsersActivity.this, UserDetailActivity.class);
				userIntent.putExtra("requestUser", selectedUser);
				startActivityForResult(userIntent, PICK_USER);
			}
		});
	}

	/*
	 * @Override protected void onResume() { super.onResume();
	 * 
	 * if (selectedPosition != -1) { Log.e("selectedPosition",
	 * Integer.toString(selectedPosition)); if (usersView != null) { View
	 * selectedUserView = usersView.getChildAt(selectedPosition); if
	 * (selectedUserView != null) { boolean isActive =
	 * UserDetailActivity.preferences.getBoolean("isActive",
	 * users.get(selectedPosition).isActive()); if (isActive) { selectedUserView
	 * .setBackgroundColor(usersView.getContext().getResources().getColor(R.
	 * color.green)); } else { selectedUserView
	 * .setBackgroundColor(usersView.getContext().getResources().getColor(R.
	 * color.red)); } } else { Log.e("NO selectedUserView", ""); } } else {
	 * Log.e("NO USERS VIEW", ""); } } else { Log.e("selectedPosition = -1",
	 * ""); } }
	 */

/*	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == PICK_USER) {
			if (resultCode == RESULT_OK) {
				User responseUser = (User) data.getExtras().get("responseUser");
				if (responseUser != null) {
					users.set(selectedPosition, responseUser);
					Log.e("SELECTED_USER", users.get(selectedPosition).toString());
					for (User u : users) {
						Log.e("FORRRR", u.toString());
					}

					// refreshList(users);

					usersView.refreshDrawableState();

					View selectedUserView = usersView.getChildAt(selectedPosition);
					boolean isActive = UserDetailActivity.preferences.getBoolean("isActive", responseUser.isActive());
					if (isActive) {
						selectedUserView
								.setBackgroundColor(usersView.getContext().getResources().getColor(R.color.green));
					} else {
						selectedUserView
								.setBackgroundColor(usersView.getContext().getResources().getColor(R.color.red));
					}

					adapter = new UserArrayAdapter(usersView.getContext(), R.layout.activity_user_row, users);
					usersView.setAdapter(adapter);

					refreshList();
				}
			}
		}
	}*/

	/*
	 * private void refreshList(List<User> users) { adapter.getValues().clear();
	 * adapter.getValues().addAll(users); adapter.notifyDataSetChanged(); }
	 */

	protected void onPause() {
		super.onPause();
		setContentView(R.layout.activity_users);
		Log.e("USERS.onPause", "");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.users, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
