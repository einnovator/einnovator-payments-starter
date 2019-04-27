package org.einnovator.payments.client.manager;

import java.security.Principal;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.util.StringUtils;
import org.einnovator.util.CacheUtils;
import org.einnovator.util.SecurityUtil;

public class ManagerBase {
	
	@SuppressWarnings("unchecked")
	protected <T> T getCacheValueForPrincipal(Class<T> type, Cache cache, Object... keys) {
		if (cache==null) {
			return null;
		}
		Principal principal = SecurityUtil.getPrincipal();
		if (principal==null) {
			return null;
		}
		String key = makeKeyForPrincipal(keys);
		ValueWrapper value = cache.get(principal.getName() + key);
		if (value!=null) {
			return (T)value.get();
		}
		return null;
	}

	protected <T> T putCacheValueForPrincipal(T value, Cache cache, Object... keys) {
		if (cache==null) {
			return value;
		}
		Principal principal = SecurityUtil.getPrincipal();
		if (principal==null) {
			return value;
		}
		String key = makeKeyForPrincipal(keys);
		cache.put(principal.getName() + key, value);
		return value;
	}


	@SuppressWarnings("unchecked")
	protected <T> T getCacheValue(Class<T> type, Cache cache, Object... keys) {
		if (cache==null) {
			return null;
		}
		String key = makeKey(keys);
		if (key!=null) {
			ValueWrapper value = cache.get(key);
			if (value!=null) {
				return (T)value.get();
			}
		}
		return null;
	}

	protected <T> T putCacheValue(T value, Cache cache, Object... keys) {
		if (cache==null) {
			return value;
		}
		String key = makeKey(keys);
		if (key!=null) {
			cache.put(key, value);
		}
		return value;
	}

	protected String makeKeyForPrincipal(Object... keys) {
		return makeKeyForUser(SecurityUtil.getPrincipalName(), keys);
	}
		

	protected String makeKeyForUser(String username, Object... keys) {
		if (username==null) {
			return null;
		}
		String key = makeKey(keys);
		return StringUtils.hasText(key) ? username + ":" + key : username;		
	}

	protected String makeKey(Object... keys) {
		return CacheUtils.makeKey(keys);
	}


}
