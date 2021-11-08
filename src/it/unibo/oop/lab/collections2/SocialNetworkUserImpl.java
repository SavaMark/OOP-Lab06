package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {
	
    private final Map<String, Set<U>> friends;
    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
    	this(name, surname, user, -1);
    }
    
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.friends = new HashMap<>();
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        Set<U> circleFriends = this.friends.get(circle);  //non clona, crea riferimento! 
        if(circleFriends == null) {
        	circleFriends = new HashSet<>();
        	this.friends.put(circle, circleFriends);
        }
        return circleFriends.add(user);
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        final Collection<U> followedUsers = this.friends.get(groupName); //metodo ritorna coll quindi crea una coll
        if (followedUsers != null) {
        	return new ArrayList<U>(followedUsers); //HashSet andava bene ugualmente?
        }
        
        return Collections.emptyList();
    }

    @Override
    public List<U> getFollowedUsers() {
        Set<U> friends = new HashSet<>();
        return null;
    }

}
