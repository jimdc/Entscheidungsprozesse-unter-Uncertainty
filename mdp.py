import mdptoolbox
import numpy as np

transitions = np.array([
#action1
	[
		[0.2, 0.8, 0, 0], #s1
		[1, 0, 0, 0], #s2 (impossible)
		[1, 0, 0, 0], #s3 (impossible)
		[0, 0, 0.9, 0.1] #s4
	],

#action2
	[
		[0.2, 0, 0, 0.8], #s1
		[0, 0.2, 0.8, 0], #s2
		[1, 0, 0, 0], #s3 (impossible)
		[1, 0, 0, 0] #s4 (impossible)
	],

#action3
	[
		[1, 0, 0, 0], #s1 (impossible)
		[0.8, 0.2, 0, 0], #s2
		[0, 0, 0, 1], #s3
		[1, 0, 0, 0] #s4 (impossible)
	],

#action4
	[
		[0.8, 0, 0, 0.2], #s1
		[1, 0, 0, 0], #s2 (impossible)
		[0, 1, 0, 0], #s3
		[1, 0, 0, 0] #s4 (impossible)
	]
])

rewards = np.array([
	[0, 0, 0, 0],
	[0, 0, 0, 0],
	[1, 1, 1, 1],
	[0, 0, 0, 0]
	])

vi = mdptoolbox.mdp.ValueIteration(transitions, rewards, 0.4, max_iter=1000)
vi.setVerbose()
vi.run()
print vi.policy
print vi.time
print vi.iter
print vi.V
