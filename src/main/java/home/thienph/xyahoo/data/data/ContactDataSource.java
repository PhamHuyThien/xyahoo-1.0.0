package home.thienph.xyahoo.data.data;

import java.util.Vector;

public final class ContactDataSource {
    public Vector groups = new Vector();

    public final void addContactToGroup(String groupName, ContactEntry contactEntry2) {
        int n = this.groups.size() - 1;
        while (n >= 0) {
            if (((ContactGroup)this.groups.elementAt(n)).getGroupName().equals(groupName)) {
                ((ContactGroup)this.groups.elementAt(n)).addContact(contactEntry2);
                return;
            }
            --n;
        }
        ContactGroup contactGroup2 = new ContactGroup(groupName);
        contactGroup2.addContact(contactEntry2);
        this.groups.addElement(contactGroup2);
    }

    public final void setGroupStatus(String groupName, int n) {
        int n2 = this.groups.size() - 1;
        while (n2 >= 0) {
            ContactGroup contactGroup2 = (ContactGroup)this.groups.elementAt(n2);
            if (contactGroup2.getGroupName().equals(groupName)) {
                contactGroup2.setGroupStatus(n);
                return;
            }
            --n2;
        }
    }
}
