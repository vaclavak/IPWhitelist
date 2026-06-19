# IPWhitelist

A plugin which allows you to filter out unwanted IP addresses.

## Downloads

[Modrinth]()

[Github]()

## Commands

`/ipwhitelist true` - Enables IP Blocking 

`/ipwhitelist false` - Disables IP Blocking

`/allowip <address>`  - Allow an IP address

`/removeip <address>` - Remove an IP address

`/listip` - List the current allowed IP addresses

`/cleariplist` - Clear the list of allowed IP addresses

## Config

**Changing the kick message:**

```yaml
#The kick message that should be shown to the player
#You can use color codes with the & prefix
kick-message: "&4You are not allowed on this server!"
```

You may use color codes prefixed with "&", available placeholders are: {IP}, {NAME}, {UUID}

**Enabling or disabling logging**

```yaml
#Enable or disable logging failed and successfull login attempts
enable-logging: true
```

## bStats

This plugin uses bStats to collect anonymous statistics. This can be disabled in bStats/config.yaml

![bStats](https://bstats.org/signatures/bukkit/IPWhitelist.svg)
