WraithQuest
===========

A completely cross-platform quest logger primarily for Minecraft custom maps.

## FEATURES

* Cross-platform: Due to the program being built in Java for Minecraft, it will run on all platforms that may need it.
* Easily create quests: Writing a quest line is very simple, and with the possible release of a dev version, it will only become simpler.
* Support for cutscenes: If needed, the map developer can include links to YouTube cutscenes or conversations with each task.

## WRITING QUESTS

Currently, writing quests isn't very intuitive. In later builds, there will be more options for making this process easier.
For now, it follows this format:

	type=The type of quest. Currently the three types are _quest_, _cutscene_ and _character_.
	name=The name of the quest.
	description=The description for the quest on a single line. This is subject to change. For paragraphing, add <p>.

This is where all the task points will be written, in the following format.

	tasks={
		Link#Description of the task point; this is what will appear in the task list#Password
	}

There can be an infinite amount of task points, all contained within the _tasks_ block. The elements are separated by the hashtag (_#_).
Keep in mind that the link is entirely optional, and if you only include two elements, they will be read like so:

	Description#Password

An example of a quest:

	type=quest
	name=Collect 10 Bear Heads
	description=The farmer wants to make a bear head stew.<p>Collect ten bear heads for him.
	tasks={
	Collect 10 bear heads.#bear
	www.youtube.com/v?=EXAMPLE#Deliver them to the farmer.#pear
	}

More examples can be found in the _quests_ folder.

## CONTACT

Contact the developers of WraithQuest at
WraithTeam@gmail.com